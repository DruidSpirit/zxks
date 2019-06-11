package cn.edu.cczu.zxks.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new MyInterceptor());
        /*同一异常和无界面*/
        interceptorRegistration.addPathPatterns("/**");

        interceptorRegistration.excludePathPatterns("/static/**");
//        interceptorRegistration.excludePathPatterns("/login");
        interceptorRegistration.excludePathPatterns("/login/gologin");
        interceptorRegistration.excludePathPatterns("/login/loginafter");
        interceptorRegistration.excludePathPatterns("/login/logout");
        interceptorRegistration.excludePathPatterns("/css/**");
        interceptorRegistration.excludePathPatterns("/js/**");
        interceptorRegistration.excludePathPatterns("/img/**");

//        interceptorRegistration.excludePathPatterns("/**");
//        interceptorRegistration.excludePathPatterns("/index");



    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //需要配置1：需要告知系统，这是要被当成静态文件的！
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    private class MyInterceptor implements HandlerInterceptor {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

            System.out.println("在控制器执行前调用 ");
            Object admin =request.getSession().getAttribute("admin");
            Object student =request.getSession().getAttribute("student");
            Object teacher =request.getSession().getAttribute("teacher");
            if (admin != null||student!=null ||teacher!=null) {
                System.out.println("当前用户已经登录!");
                return true;
            }else{
                System.out.println("当前用户还未登录!");
                response.sendRedirect( "/login/gologin");
                return false;
            }

        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
            //controller方法处理完毕后，调用此方法
            System.out.println("在后端控制器执行后调用 ");
        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
            //页面渲染完毕后调用此方法
            System.out.println("整个请求执行完成后调用 ");
        }
    }

}
