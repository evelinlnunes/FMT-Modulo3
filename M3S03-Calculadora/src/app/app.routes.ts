import { Routes } from '@angular/router';
import { CalculadoraComponent } from './calculadora/calculadora.component';

export const routes: Routes = [
    {
      path: 'calculadora',
      component: CalculadoraComponent,
    },
    { path: '', redirectTo: '/calculadora', pathMatch: 'full' },
    { path: '**', redirectTo: '/calculadora' },
  ];