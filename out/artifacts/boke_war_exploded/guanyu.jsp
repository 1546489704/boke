<%--
  Created by IntelliJ IDEA.
  User: H丶丢心先生
  Date: 2018/11/27
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="shortcut icon" href="cc.ico">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>风风博客-关于博客</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            overflow: hidden;
        }
    </style>
</head>
<body>
<canvas id="canvas" style="background:#000">

</canvas>
<div style="color: white;position: fixed;left: 500px;top: 300px;">
    <h2>风风博客,只为展示风风身边的一事一物</h2></br>
</div>
<script type="text/javascript">
    (function (window, factory) {
        if (typeof define === "function" && define.amd) {
            define(factory)
        } else {
            if (typeof module === "object" && module.exports) {
                module.exports = factory()
            } else {
                window.martrix = factory()
            }
        }
    }(typeof window !== "undefined" ? window : this, function () {
        var martrix = function (selector, userOptions) {
            var options = {
                cW: 1368,
                cH: 600,
                wordColor: "#ff000e",
                fontSize: 16,
                speed: 0.08,
                 words: "0123456789qwertyuiopasdfghjklzxcvbnm,./;'[]QWERTYUIOP{}ASDFGHJHJKL:ZXCVBBNM<>?"

            };
            var canvas, ctx, W, H, clumns, wordsArr, drops = [];
            var mergeOptions = function (userOptions, options) {
                Object.keys(userOptions).forEach(function (key) {
                    options[key] = userOptions[key]
                })
            };
            var draw = function () {
                ctx.save();
                ctx.fillStyle = options.wordColor;
                ctx.font = options.fontSize + "px arial";
                ctx.fontWeight = options.fontWeight;
                for (var i = 0; i < drops.length; i++) {
                    var text = wordsArr[Math.floor(Math.random() * wordsArr.length)];
                    ctx.fillText(text, i * options.fontSize, drops[i] * options.fontSize);
                    if (drops[i] * options.fontSize > H && Math.random() > 0.98) {
                        drops[i] = 0
                    }
                    drops[i]++
                }
                ctx.restore()
            };
            var initSetup = function (selector, userOptions) {
                mergeOptions(userOptions, options);
                canvas = document.getElementById(selector);
                ctx = canvas.getContext("2d");
                canvas.height = H = options.cH;
                canvas.width = W = options.cW;
                clumns = options.cW / options.fontSize;
                wordsArr = options.words.split("");
                for (var i = 0; i < clumns; i++) {
                    drops[i] = 1
                }
                (function drawFrame() {
                    window.requestAnimationFrame(drawFrame);
                    ctx.fillStyle = "rgba(0,0,0," + options.speed + ")";
                    ctx.fillRect(0, 0, W, H);
                    draw()
                }())
            };
            initSetup(selector, userOptions)
        };
        return martrix
    }));
    //instance
    martrix('canvas', {
        cW: 2000,
        cH: 700,
        wordColor: '#19ff1a',
        fontSize: 15,
        speed: 0.08,
    });
</script>
</body>
</html>