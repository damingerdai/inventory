import { Component } from '@angular/core';
import { BsModalRef } from 'ngx-bootstrap/modal';

@Component({
  selector: 'app-gift-modal',
  templateUrl: './gift.modal.component.html',
})
export class GiftModalComponent {

  title: string;

  constructor(public modalRef: BsModalRef) {

  }

}
