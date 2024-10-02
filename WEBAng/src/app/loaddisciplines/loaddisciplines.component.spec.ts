import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoaddisciplinesComponent } from './loaddisciplines.component';

describe('LoaddisciplinesComponent', () => {
  let component: LoaddisciplinesComponent;
  let fixture: ComponentFixture<LoaddisciplinesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LoaddisciplinesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoaddisciplinesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
