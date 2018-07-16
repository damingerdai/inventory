import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MenuService } from '../core/menu/menu.service';

import { menus } from './menu';
import { routes } from './routes';

@NgModule({
    imports: [
        RouterModule.forRoot(routes),
    ],
    declarations: [],
    exports: [
        RouterModule
    ]
})

export class RoutesModule {
    constructor(public menuService: MenuService) {
        menuService.addMenu(menus);
    }
}
