import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { PerfilComprasComponent } from './perfil-compras.component';

describe('PerfilComprasComponent', () => {
  let component: PerfilComprasComponent;
  let fixture: ComponentFixture<PerfilComprasComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [PerfilComprasComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(PerfilComprasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
