
// export var url=window.location.protocol + "//" + window.location.host + "/";

export var url="http://localhost:8080/bank-of-rest/";
export var newURL = window.location.protocol + "//" + window.location.host + "/" + window.location.pathname;
 var jwtKEY = "";
 export let setKey=function(key:string){
   jwtKEY=key;
 }
  export let key=function(){
   return jwtKEY
 }