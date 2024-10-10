import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalculadoraComponent } from './calculadora.component';

describe('CalculadoraComponent', () => {
  let component: CalculadoraComponent;
  let fixture: ComponentFixture<CalculadoraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CalculadoraComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(CalculadoraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('deve adicionar 2 numeros e retornar a resposta correta', () => {
    component.num1 = 12;
    component.num2 = 20;
    component.somar();
    expect(component.result).toBe(32);
  });

  it('deve alterar os valores num1 e num2 no formulário, apertar o botão de soma e retornar resultado correto do cálculo', () => {
    const spy = spyOn(component, 'somar').and.callThrough();
    const input1 = fixture.nativeElement.querySelector('#num1');
    const input2 = fixture.nativeElement.querySelector('#num2');
    const button = fixture.nativeElement.querySelector('#somarBtn');
    input1.value = 35;
    input2.value = 12;
    input1.dispatchEvent(new Event('input'));
    input2.dispatchEvent(new Event('input'));
    button.click();
    expect(spy).toHaveBeenCalled(); 
    expect(component.result).toBe(37);
  });

});
