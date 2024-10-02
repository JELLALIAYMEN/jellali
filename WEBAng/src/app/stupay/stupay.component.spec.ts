import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StupayComponent } from './stupay.component';

describe('StupayComponent', () => {
  let component: StupayComponent;
  let fixture: ComponentFixture<StupayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [StupayComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StupayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
