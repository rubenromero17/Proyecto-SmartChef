import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { PaginaPerfilComponent } from './pagina-perfil.component';

describe('PaginaPerfilComponent', () => {
  let component: PaginaPerfilComponent;
  let fixture: ComponentFixture<PaginaPerfilComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [PaginaPerfilComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(PaginaPerfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
