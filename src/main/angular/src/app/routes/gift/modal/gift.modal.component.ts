import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BsModalRef } from 'ngx-bootstrap/modal';
import { ToasterService} from 'angular2-toaster';
import { CommonResponse } from '../../../model/response';


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
    public http: HttpClient,
    private toasterService: ToasterService) {

  }

  saveGift() {
    this.toasterService.popAsync('info', '通知', '成功');
    if (this.giftCode && this.giftName) {
      this.http.post<CommonResponse>('/api/v1/gift', {code: this.giftCode, name: this.giftName}).subscribe(res => {
        if (res.statusCode === 200) {
          alert('成功');
          this.modalRef.hide();
        } else {
          alert(res.error.message);
        }
      });
    } else {
      this.errorMsg = '请输入完整';
    }
  }

}
