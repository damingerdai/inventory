import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Gift } from '../../../modal/gift';
import { Page, PageInfo } from '../../../modal/page';
import { PageResponse, ErrorResponse } from '../../../modal/response';

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

    constructor(private http: HttpClient) { }

    ngOnInit() {
        this.http.get<PageResponse<Gift> | ErrorResponse>('/api/v1/gift', { params: {
            name: this.name || '',
            pageNo: this.page.pageNo + '' || '1',
            pageSize: this.page.pageSize + '' || '5',
        }}).subscribe(res => {
            if (res instanceof ErrorResponse) {
                alert(res.error.message);
            } else {
                this.gifts = res.data;
                this.pageInfo = res.pageInfo;
            }
        });
    }

}