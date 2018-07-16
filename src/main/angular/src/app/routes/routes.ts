import { LayoutComponent } from '../layout/layout.component';


export const routes = [

    {
        path: '',
        component: LayoutComponent,
        children: [
            { path: '', redirectTo: 'gift', pathMatch: 'full' },
            { path: 'gift', loadChildren: './gift/gift.module#GiftModule' },
        ]
    },

    // Not found
    { path: '**', redirectTo: 'home' }

];
