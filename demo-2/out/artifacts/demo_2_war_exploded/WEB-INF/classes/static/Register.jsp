<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>register</title>
    </head>
    <body>
    <h2>��ӭע��</h2>
    <form action="xdserviceuser/register" method="post">
        <div>
            <ul>
                <li>
                    <input type="number" name="serviceName" placeholder="����">
                </li>
                <li>
                    <input type="password" name="servicePassword" placeholder="����">
                </li>
                <li>
                    <input type="text" name="area" placeholder="����">
                </li>
            </ul>
            <div>
                <button type="submit" >ע��</button>
            </div>
        </div>
    </form>
    </body>
    </html>
