import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GiftListComponent } from './list/gift.list.component';
import { CommonModule } from '@angular/common';

const routes: Routes = [
    { path: '', component: GiftListComponent },
];

@NgModule({
    imports: [
        CommonModule,
        RouterModule.forChild(routes)
    ],
    declarations: [
        GiftListComponent],
    exports: [
        RouterModule
    ]
})
export class GiftModule { }