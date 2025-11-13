import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { PaginaBuscarComponent } from './pagina-buscar.component';

describe('PaginaBuscarComponent', () => {
  let component: PaginaBuscarComponent;
  let fixture: ComponentFixture<PaginaBuscarComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [PaginaBuscarComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(PaginaBuscarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
