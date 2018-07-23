import { PageInfo } from './page';

export class CommonResponse {
    statusCode: number;
    error?: Error;
}

export class ErrorResponse extends CommonResponse {
    error: Error;
}

export class DataResponse<T> extends CommonResponse {
    data: T;
}

export class ListResponse<T> extends CommonResponse {
    data: T[];
}

export class PageResponse<T> extends ListResponse<T> {
    pageInfo: PageInfo;
}

interface Error {
    code: string;
    message: string;
}
