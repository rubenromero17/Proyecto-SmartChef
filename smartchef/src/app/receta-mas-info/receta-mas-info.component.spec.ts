import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { RecetaMasInfoComponent } from './receta-mas-info.component';

describe('RecetaMasInfoComponent', () => {
  let component: RecetaMasInfoComponent;
  let fixture: ComponentFixture<RecetaMasInfoComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [RecetaMasInfoComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(RecetaMasInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
