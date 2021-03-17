<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='en'>
  <head>
    <meta charset='utf-8' />
    <link href='fullcalendar/main.css' rel='stylesheet' />
    <script src='fullcalendar/main.js'></script>
    <script>

      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth',
          displayEventEnd: true,
          headerToolbar: {
              left: '',
              center: 'title',
              right: ''
            },
          events: [
              {
                title: '요가',
                start: '2021-03-20',
                color: 'red',
              },
                {
                  title: '요가',
                  start: '2021-03-22',
                  color: 'red',
                }
          	]
        });
        calendar.render();
      });

    </script>
  </head>
  <body>
  	<div style="display: flex; justify-content: space-between;" id='container'>
  	    <div style="margin:5px; height:500px; width:800px;" id='calendar'></div>
  	    <div style="margin:5px; background:gray; height:500px; width:800px;" id='a1'></div>
  	    <div style="margin:5px; background:olive; height:500px; width:800px;" id='a2'></div>
    </div>
    <div id='container2'>
    	<button type='submit'>오전예약</button>
    	<button type='submit'>오후예약</button>
    </div>
  </body>
</html>