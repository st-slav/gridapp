import { Component, TemplateRef, ViewChild, OnInit } from '@angular/core';
import { User } from './user';
import { UserService } from './user.service';
import {Observable} from 'rxjs/Observable';
import 'rxjs/Rx';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
    providers: [UserService]
})
export class AppComponent implements OnInit {

    //типы шаблонов
    @ViewChild('readOnlyTemplate') readOnlyTemplate: TemplateRef<any>;
    @ViewChild('editTemplate') editTemplate: TemplateRef<any>;

    editedUser: User;
    users: Array<User>;
    isNewRecord: boolean;
    statusMessage: string;

    constructor(private api: UserService) {
        this.users = new Array<User>();
    }

    ngOnInit() {
        this.loadUsers();
    }

    //загрузка пользователей
    private loadUsers() {
        this.api.getUsers().subscribe((data: User[]) => {
            this.users = data;
        });
    }

    // добавление пользователя
    addUser() {
        this.editedUser = new User(null, "", 0);
        this.users.push(this.editedUser);
        this.isNewRecord = true;
    }

    // редактирование пользователя
    editUser(user: User) {
        this.editedUser = new User(user.id, user.name, user.age);
    }

    // загружаем один из двух шаблонов
    loadTemplate(user: User) {
        if (this.editedUser && this.editedUser.id == user.id) {
            return this.editTemplate;
        } else {
            return this.readOnlyTemplate;
        }
    }

    // сохраняем пользователя
    saveUser() {
        if (this.isNewRecord) {
            // добавляем пользователя
            this.api.createUser(this.editedUser).subscribe(data => {
                this.statusMessage = 'Данные успешно добавлены';
                this.loadUsers();
            });
            this.isNewRecord = false;
        } else {
            // изменяем пользователя
            this.api.updateUser(this.editedUser.id, this.editedUser).subscribe(data => {
                this.statusMessage = 'Данные успешно обновлены';
                this.loadUsers();
            });
        }
        this.editedUser = null;
    }

    // отмена редактирования
    cancel() {
        // если отмена при добавлении, удаляем последнюю запись
        if (this.isNewRecord) {
            this.users.pop();
            this.isNewRecord = false;
        }
        this.editedUser = null;
    }

    // удаление пользователя
    deleteUser(user: User) {
        this.api.deleteUser(user.id).subscribe(data => {
            this.statusMessage = 'Данные успешно удалены';
            this.loadUsers();
        });
    }
}
