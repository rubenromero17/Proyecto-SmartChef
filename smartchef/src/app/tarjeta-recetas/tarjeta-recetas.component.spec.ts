import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { TarjetaRecetasComponent } from './tarjeta-recetas.component';

describe('TarjetaRecetasComponent', () => {
  let component: TarjetaRecetasComponent;
  let fixture: ComponentFixture<TarjetaRecetasComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [TarjetaRecetasComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(TarjetaRecetasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
