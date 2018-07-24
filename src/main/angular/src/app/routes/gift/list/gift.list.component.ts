import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';
import { combineLatest, Subscription } from 'rxjs';
import { ToasterService } from 'angular2-toaster';
import { Gift } from '../../../model/gift';
import { Page, PageInfo } from '../../../model/page';
import { PageResponse, ErrorResponse } from '../../../model/response';
import { GiftModalComponent } from '../modal/gift.modal.component';

@Component({
    selector: 'app-gift-list',
    templateUrl: './gift.list.component.html',
    styleUrls: ['./gift.list.component.css']
})
export class GiftListComponent implements OnInit {

    name: string;
    page: Page = {
        pageNo: 1,
        pageSize: 5,
    };
    pageInfo: PageInfo;
    gifts: Gift[];

    modalRef: BsModalRef;
    subscriptions: Subscription[] = [];

    constructor(
        private http: HttpClient,
        private modalService: BsModalService,
        private changeDetection: ChangeDetectorRef,
        private toasterService: ToasterService,
    ) { }

    add() {
        const _combine = combineLatest(
            this.modalService.onHidden
        ).subscribe(() => this.changeDetection.markForCheck());

        this.subscriptions.push(
            this.modalService.onHidden.subscribe((reason: string) => {
                this.ngOnInit();
                this.unsubscribe();
            })
        );

        this.subscriptions.push(_combine);

        this.modalRef = this.modalService.show(GiftModalComponent);
        this.modalRef.content.title = '添加礼品';
        this.modalRef.content.type = 'add';
    }

    updateGift(gift: Gift) {
        const _combine = combineLatest(
            this.modalService.onHidden
        ).subscribe(() => this.changeDetection.markForCheck());

        this.subscriptions.push(
            this.modalService.onHidden.subscribe((reason: string) => {
                this.ngOnInit();
                this.unsubscribe();
            })
        );

        this.subscriptions.push(_combine);

        this.modalRef = this.modalService.show(GiftModalComponent);
        this.modalRef.content.title = '编辑礼品';
        this.modalRef.content.type = 'edit';
        this.modalRef.content.giftCode = gift.code;
        this.modalRef.content.giftName = gift.name;
        this.modalRef.content.giftId = gift.id;
    }

    deleteGift(id: number) {
        this.toasterService.popAsync('error', '错误', '删除礼品失败');
    }

    ngOnInit() {
        this.http.get<PageResponse<Gift> | ErrorResponse>('/api/v1/gift', {
            params: {
                name: this.name || '',
                pageNo: this.page.pageNo + '' || '1',
                pageSize: this.page.pageSize + '' || '5',
            }
        }).subscribe(res => {
            if (res instanceof ErrorResponse) {
                this.toasterService.popAsync('error', '错误', res.error.message);
            } else {
                this.gifts = res.data;
                this.pageInfo = res.pageInfo;
            }
        });
    }

    unsubscribe() {
        this.subscriptions.forEach((subscription: Subscription) => {
            subscription.unsubscribe();
        });
        this.subscriptions = [];
    }

}