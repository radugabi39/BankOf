
	
export class User {

     firstName: string;
     lastName: string;
     phone: string;
     address: string;
     CNP: string;
     email:string;

	
    constructor( firstName: string, lastName: string, phone: string, address: string, CNP: string,email:string) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.CNP = CNP;
                this.email = email;
    }

    static fromJSONArray(array: Array<Object>): User[] {
        return array["data"].map(obj => new User(obj['firstName'], obj['lastName'], obj['phone'], obj['address'], obj['CNP'], obj['email']));
    }
}