import {Component} from '@angular/core'

@Component({
    selector: 'app-root',
    template: `
        <div>
            <h3>First Angular Component changed- should!!</h3>
            <p>{{message}}</p>
            <button (click)="someAction()">Some Action</button>
            <my-badge></my-badge>
        </div>
    `
})
export class AppComponent {

    constructor() { }

    message: string = 'Some Meesage'
    x: number = 23;

    someAction(){
        console.log('Click event fired...')
    }

}