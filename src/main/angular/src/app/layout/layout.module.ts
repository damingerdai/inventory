import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { LayoutComponent } from './layout.component';


@NgModule({
    imports: [
        CommonModule,
        RouterModule,
    ],
    providers: [

    ],
    declarations: [
        LayoutComponent,
        HeaderComponent,
    ],
    exports: [
        LayoutComponent,
        HeaderComponent,
    ]
})
export class LayoutModule { }