import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ModalModule } from 'ngx-bootstrap/modal';
import { GiftListComponent } from './list/gift.list.component';
import { GiftModalComponent } from './modal/gift.modal.component';

const routes: Routes = [
    { path: '', component: GiftListComponent },
];

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        ModalModule.forRoot(),
        RouterModule.forChild(routes)
    ],
    declarations: [
        GiftModalComponent,
        GiftListComponent,
    ],
    entryComponents: [
        GiftModalComponent
    ],
    exports: [
        RouterModule
    ]
})
export class GiftModule { }