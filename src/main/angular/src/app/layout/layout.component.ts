import { Component, OnInit } from '@angular/core';
import { MenuService } from '../core/menu/menu.service';

@Component({
    selector: 'app-layout',
    templateUrl: './layout.component.html',
    styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {

    menuItems: any[] = [];

    constructor(
        private menus: MenuService
    ) {
        this.menuItems = menus.getMenu();
    }

    ngOnInit() {
    }

}
