import { create, createReportList } from './modules/canvas.js';
import {draw as newdraw, newname, reportArea, reportPerimeter } from './modules/rect.js';
import randomSquare from './modules/rect.js';

let myCanvas = create('myCanvas', document.body, 480, 320);
let reportList = createReportList(myCanvas.id);

let square1 = newdraw(myCanvas.ctx, 50, 50, 100, 'blue');
reportArea(square1.length, reportList);
reportPerimeter(square1.length, reportList);

// Use the default
let square2 = randomSquare(myCanvas.ctx);