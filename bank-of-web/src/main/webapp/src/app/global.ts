
// export var url=window.location.protocol + "//" + window.location.host + "/";

export var url="http://localhost:8080/bank-of-rest/";
export var newURL = window.location.protocol + "//" + window.location.host + "/" + window.location.pathname;
 var jwtKEY = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpYm1Vc2VyIiwiZXhwIjoxNDk2OTQwMDc5fQ.WMV-xnM-FPpjx9D3fBHXAN78xDi-D58I8aERVf7TzM2KRmfQWwUeXVgq1nk0Dtru3Y-kjS4wYHmOGMlz2TuUyA";
 export let setKey=function(key:string){
   jwtKEY=key;
 }
  export let key=function(){
   return jwtKEY
 }