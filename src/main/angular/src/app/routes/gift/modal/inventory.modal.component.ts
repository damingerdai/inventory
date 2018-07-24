import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BsModalRef } from 'ngx-bootstrap/modal';
import { ToasterService } from 'angular2-toaster';
import { CommonResponse } from '../../../model/response';


@Component({
  selector: 'app-inventory-modal',
  templateUrl: './inventory.modal.component.html',
})
export class InventoryModalComponent {

  errorMsg: string;

  giftId: number;
  giftInventory: number;

  constructor(
    public modalRef: BsModalRef,
    public http: HttpClient,
    private toasterService: ToasterService) {

  }


  update() {
    if (this.giftInventory && this.giftInventory > 0) {
      // tslint:disable-next-line:max-line-length
      this.http.put<CommonResponse>('/api/v1/gift/' + this.giftId + '/inventory', { num: this.giftInventory}).subscribe(res => {
        if (res.statusCode === 200) {
          this.modalRef.hide();
          this.toasterService.popAsync('success', '通知', '库存更新成功');
        } else {
          this.toasterService.popAsync('error', '错误', res.error.message);
        //  alert(res.error.message);
        }
      });
    } else {
      this.errorMsg = '请输入正确的新库存';
    }
  }

// tslint:disable-next-line:eofline
}