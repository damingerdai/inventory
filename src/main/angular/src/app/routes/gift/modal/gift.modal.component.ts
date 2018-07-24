import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BsModalRef } from 'ngx-bootstrap/modal';
import { ToasterService } from 'angular2-toaster';
import { CommonResponse } from '../../../model/response';


@Component({
  selector: 'app-gift-modal',
  templateUrl: './gift.modal.component.html',
})
export class GiftModalComponent {

  type: string;
  title: string;

  errorMsg: string;

  giftId: number;
  giftCode: string;
  giftName: string;

  constructor(
    public modalRef: BsModalRef,
    public http: HttpClient,
    private toasterService: ToasterService) {

  }

  saveGift() {
    if (this.giftCode && this.giftName) {
      this.http.post<CommonResponse>('/api/v1/gift', { code: this.giftCode, name: this.giftName }).subscribe(res => {
        if (res.statusCode === 200) {
          this.modalRef.hide();
          this.toasterService.popAsync('success', '通知', '礼品添加成功');
        } else {
          this.toasterService.popAsync('error', '错误', res.error.message);
         // alert(res.error.message);
        }
      });
    } else {
      this.errorMsg = '请输入完整';
    }
  }

  updatGift() {
    if (this.giftCode && this.giftName) {
      this.http.put<CommonResponse>('/api/v1/gift', { id: this.giftId, code: this.giftCode, name: this.giftName }).subscribe(res => {
        if (res.statusCode === 200) {
          this.modalRef.hide();
          this.toasterService.popAsync('success', '通知', '礼品更新成功');
        } else {
          this.toasterService.popAsync('error', '错误', res.error.message);
        //  alert(res.error.message);
        }
      });
    } else {
      this.errorMsg = '请输入完整';
    }
  }

}
