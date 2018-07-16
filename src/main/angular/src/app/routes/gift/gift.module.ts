import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GiftListComponent } from './list/gift.list.component';

const routes: Routes = [
    { path: '', component: GiftListComponent },
];

@NgModule({
    imports: [
        RouterModule.forChild(routes)
    ],
    declarations: [
        GiftListComponent],
    exports: [
        RouterModule
    ]
})
export class GiftModule { }