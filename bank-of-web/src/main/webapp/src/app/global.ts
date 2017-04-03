
// export var url=window.location.protocol + "//" + window.location.host + "/";

export var url="http://localhost:8080/bank-of-rest/";
export var newURL = window.location.protocol + "//" + window.location.host + "/" + window.location.pathname;
 var jwtKEY = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpYm1Vc2VyIiwiZXhwIjoxNDkyMTAyODA0fQ.A7bKYke9XhRlrUoPYORuVjnycGeCa6CvFMZtvh038kPXpRtpOeoK14QmZF7VcIf9eTb1UZtgA9hnKQGa-cIi3g";
 export let setKey=function(key:string){
   jwtKEY=key;
 }
  export let key=function(){
   return jwtKEY
 }