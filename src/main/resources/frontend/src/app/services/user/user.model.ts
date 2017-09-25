import { Captcha } from '../captcha/captcha.model';

export interface User {
    email: string;
    password: string;
    firstname: string;
    lastname: string;
    phoneNumber: string;
    captcha?: Captcha;
}