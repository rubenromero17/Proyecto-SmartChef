import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { FiltrosHomeComponent } from './filtros-home.component';

describe('FiltrosHomeComponent', () => {
  let component: FiltrosHomeComponent;
  let fixture: ComponentFixture<FiltrosHomeComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [FiltrosHomeComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(FiltrosHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
