import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ToasterModule } from 'angular2-toaster';
import { ModalModule } from 'ngx-bootstrap/modal';
import { GiftListComponent } from './list/gift.list.component';
import { GiftModalComponent } from './modal/gift.modal.component';
import { InventoryModalComponent } from './modal/inventory.modal.component';

const routes: Routes = [
    { path: '', component: GiftListComponent },
];

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        ToasterModule.forRoot(),
        ModalModule.forRoot(),
        RouterModule.forChild(routes)
    ],
    declarations: [
        GiftModalComponent,
        GiftListComponent,
        InventoryModalComponent,
    ],
    entryComponents: [
        GiftModalComponent,
        InventoryModalComponent
    ],
    exports: [
        RouterModule
    ]
})
export class GiftModule { }