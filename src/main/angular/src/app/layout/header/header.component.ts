import { Component, OnInit } from '@angular/core';
import { MenuService } from '../../core/menu/menu.service';


@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

    menuItems: any[] = [];

    constructor(
        private menus: MenuService
    ) {
        this.menuItems = menus.getMenu();
    }

    ngOnInit() {
    }
}
