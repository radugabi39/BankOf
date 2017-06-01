
	
export class ToastModel {

     text: string;
     error: Boolean;

	
    constructor( text: string, error: Boolean) {
        this.text = text;
        this.error = error;
    }

}