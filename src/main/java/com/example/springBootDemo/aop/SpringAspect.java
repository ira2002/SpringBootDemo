package com.example.springBootDemo.aop;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.javassist.ClassClassPath;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.CtMethod;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.springBootDemo.util.ResultMap;


/**
 * Spring AOP 面向切面事物代理
 * @author admin
 *
 */
@Component
@Aspect
public class SpringAspect {
	private final Logger logger = Logger.getLogger(SpringAspect.class);

	/**
	 * web AOP
	 * @param point
	 * @return
	 */
	@Around("within(com.example.springBootDemo.controller.*Controller))")
	public Object webAspect(ProceedingJoinPoint point) {
		try {
			if(logger.isDebugEnabled()) {
				//TODO AOP:接收到请求，记录请求内容 (注:会占用部分处理时间,生产环境不要启用该日志信息) 
				
				ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
				HttpServletRequest request = attributes.getRequest();  
				//
				String classType = point.getTarget().getClass().getName();
				Class<?> clazz = Class.forName(classType);
				String clazzName = clazz.getName();
				String methodName = point.getSignature().getName(); //获取方法名称 
				//获取参数名称和值 
				Object[] args = point.getArgs();
				Map<String,Object > nameAndArgs = this.getFieldsName(this.getClass(), clazzName, methodName,args);
				
				// 记录下请求内容, Linux下需要通过logger记录日志到文件中查看  
				System.err.println("URL : " + request.getRequestURL().toString());  
				System.err.println("http_method : " + request.getMethod());  
				System.err.println("IP : " + request.getRemoteAddr());  
				System.err.println("class_method : " + clazzName + "." + methodName);  
				System.err.println("request parameters : "+nameAndArgs);
			}
			
			//处理业务,通过反射执行目标对象的连接点处的方法； 
			Object obj = point.proceed();

			if(logger.isDebugEnabled()) {
				System.err.println("response data : " + obj);
			}

			//返回业务数据
			return obj;
		}catch(Throwable e) {
			//e.printStackTrace();
			logger.error("web_error : "+e.getMessage(), e);
			return ResultMap.error("error : " + e.getMessage());
			//用于支持Controller层事物管理- 注解@Transactional于Controller类或者controller方法上 (则ajax请求返回状态为失败)
			//throw new RuntimeException(e);
		}finally {
			//最终通知
		}
	}

	/**
	 *  获取字段名和字段值
	 * @param cls
	 * @param clazzName
	 * @param methodName
	 * @param args
	 * @return
	 * @throws Exception
	 */
	private Map<String,Object> getFieldsName(Class cls, String clazzName, String methodName, Object[] args) throws Exception { 
		Map<String,Object > map=new HashMap<String,Object>();


		ClassPool pool = ClassPool.getDefault();  
		ClassClassPath classPath = new ClassClassPath(cls);  
		pool.insertClassPath(classPath);  

		CtClass cc = pool.get(clazzName);  
		CtMethod cm = cc.getDeclaredMethod(methodName);  
		MethodInfo methodInfo = cm.getMethodInfo(); 
		CodeAttribute codeAttribute = methodInfo.getCodeAttribute();  
		LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);  
		if (attr == null) {  
			// exception  
		}  
		int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;  
		for (int i = 0; i < cm.getParameterTypes().length; i++){  
			map.put( attr.variableName(i + pos),args[i]);//paramNames即参数名  
		}  
		return map;  
	}  
}


