import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-automoveis',
  standalone: true,
  imports: [],
  templateUrl: './automoveis.component.html',
  styleUrl: './automoveis.component.css'
})
export class AutomoveisComponent {
  automoveisList: any = [];
  router = inject(Router);

  redirectTo(id: number) {
    this.router.navigate(['/automoveis', id]);
  }
}
