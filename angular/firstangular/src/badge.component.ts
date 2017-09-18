import {Component, OnInit} from '@angular/core'

@Component({
    selector: 'my-badge',
    template: `
    <button (click)="increment()" class="btn btn-primary" type="button">
     Messages <span class="badge">{{count}}</span>
    </button>

    `
})
export class BadgeComponent implements OnInit{

    constructor() { }
    count: number = 44;

    ngOnInit(){
        console.log('On Initialization')
    }

    increment(){
        console.log('Incrementing')
        this.count = this.count+1;
    }
}