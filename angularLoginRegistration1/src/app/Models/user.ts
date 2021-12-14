export class User {

    private id!:number;
    private name!:string;
    private username!:string;
    private password!:string;

    constructor(){}

    setUsername(username:string) {
        this.username = username;
    }

    setPassword(password:string) {
        this.password = password;
    }

    getUsername():string {
        return this.username;
    }

    getPassword(): string {
        return this.password;
      }
     

}
