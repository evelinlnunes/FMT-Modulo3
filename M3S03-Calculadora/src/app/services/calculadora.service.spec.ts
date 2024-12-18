import { TestBed } from '@angular/core/testing';

import { CalculadoraService } from './calculadora.service';

describe('CalculadoraService', () => {
  let service: CalculadoraService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CalculadoraService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('deve adicionar 2 numeros e retornar a resposta correta', () => {
    expect(service.somar(12, 23)).toBe(35);
  });
  it('deve subtrair 2 numeros e retornar a resposta correta', () => {
    expect(service.subtrair(32, 12)).toBe(20);
  });

  it('deve multiplicar 2 numeros e retornar a resposta correta', () => {
    expect(service.multiplicar(64, 3)).toBe(192);
  });

  it('deve dividir 2 numeros e retornar a resposta correta', () => {
    expect(service.dividir(40, 5)).toBe(8);
  });

  it('deve retornar erro "Divisão por zero" ao tentar dividir por 0', () => {
    expect(() => service.dividir(17, 0)).toThrowError('Não é permitida a divisão por 0');
  });
});
