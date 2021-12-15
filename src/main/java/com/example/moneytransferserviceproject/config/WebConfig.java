/*
package com.example.moneytransferserviceproject.config;


import com.example.moneytransferserviceproject.model.CardAmount;
import com.example.moneytransferserviceproject.model.Transfer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new TransferArgumentResolver());

    }

    private static final class TransferArgumentResolver implements HandlerMethodArgumentResolver {

        @Override
        public boolean supportsParameter(MethodParameter parameter) {
            return parameter.getParameterType().isAssignableFrom(Transfer.class);
        }

        @Override
        public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                      NativeWebRequest webRequest, WebDataBinderFactory binderFactory)  {
            String cardFromNumber = webRequest.getParameter("cardFromNumber");
            String cardFromValidTill = webRequest.getParameter("cardFromValidTill");
            String cardFromCVV = webRequest.getParameter("cardFromCVV");

            String cardToNumber = webRequest.getParameter("cardToNumber");

            String  value = webRequest.getParameter("value");
            String currency = webRequest.getParameter("currency");


            return new Transfer(cardFromNumber, cardFromValidTill, cardFromCVV, cardToNumber,
                    new CardAmount(Integer.parseInt(value), currency));
        }
    }
}
*/
