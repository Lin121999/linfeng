package com.linfeng.demo.lfcontroller;


import com.linfeng.demo.lfservice.ITestXService;
import com.linfeng.lfspring.annotation.LFAutowired;
import com.linfeng.lfspring.annotation.LFController;
import com.linfeng.lfspring.annotation.LFRequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@LFController
@LFRequestMapping("/test")
public class TestController {

    @LFAutowired
    ITestXService testXService;

    @LFRequestMapping("/query")
    public void query(HttpServletRequest req, HttpServletResponse resp) {

        if (req.getParameter("username") == null) {

            try {
                resp.getWriter().write("param username is null");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            String paramName = req.getParameter("username");

            try {
                resp.getWriter().write("param username is " + paramName);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("[INFO-req] New request param username-->" + paramName);
        }
    }

    @LFRequestMapping("/listClassName")
    public void listClassName(HttpServletRequest req, HttpServletResponse resp) {

        String str = testXService.listClassName();

        System.out.println("testXService----------=-=-=>" + str);
        try {
            resp.getWriter().write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}