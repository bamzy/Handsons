import { create, createReportList } from './modules/canvas.js';
// import {draw as newdraw, newname, reportArea, reportPerimeter } from './modules/rect.js';
import randomSquare from './modules/rect.js';
import * as rect from './modules/rect.js';

let myCanvas = create('myCanvas', document.body, 480, 320);
let reportList = createReportList(myCanvas.id);

let square1 = rect.newdraw(myCanvas.ctx, 50, 50, 100, 'blue');
rect.reportArea(square1.length, reportList);
rect.reportPerimeter(square1.length, reportList);

// Use the default
let square2 = rect.randomSquare(myCanvas.ctx);