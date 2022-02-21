package com.wsd.servlet;

import com.alibaba.fastjson.JSON;
import com.wsd.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: wsd165
 * @description $description
 * @author: wansidong
 * @create: 2022-02-21 12:02
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader reader = request.getReader();

        String json = reader.readLine();
        System.out.println("json = " + json);
        //把json字符串转成Java对象
        User user = JSON.parseObject(json, User.class);
        System.out.println("user = " + user);

        //把Java对象转成json对象
        String jsonString = JSON.toJSONString(user);
        System.out.println("jsonString = " + jsonString);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.print(json);

    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
