import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BsModalRef } from 'ngx-bootstrap/modal';


@Component({
  selector: 'app-gift-modal',
  templateUrl: './gift.modal.component.html',
})
export class GiftModalComponent {

  title: string;

  errorMsg: string;

  giftCode: string;
  giftName: string;

  constructor(
    public modalRef: BsModalRef,
    public http: HttpClient) {

  }

  saveGift() {
    if (this.giftCode && this.giftName) {
      this.http.post('/', {giftCode: this.giftCode, giftName: this.giftName});
    } else {
      this.errorMsg = '请输入完整';
    }
  }

}
