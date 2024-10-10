import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { AutomoveisService } from '../../services/automoveis.service';

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

  automoveisService = inject(AutomoveisService);

  ngOnInit(): void {
    this.automoveisService.list().subscribe({
      next: (data: any) => {
        this.automoveisList = data;
        console.log(this.automoveisList);
      },
      error: (error) => {
        console.error('Erro ao listar pacientes: ', error);
      },
    });
  }
  
  redirectTo(id: number) {
    this.router.navigate(['/automoveis', id]);
  }
}
