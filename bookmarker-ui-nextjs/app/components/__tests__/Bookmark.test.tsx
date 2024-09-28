// // __tests__/Bookmark.test.tsx
// import React from 'react';
// import { render, screen } from '@testing-library/react';
// import '@testing-library/jest-dom';
//
// import Bookmark from '../Bookmark';
// import { Bookmark as BookmarkModel } from '../../services/models';
//
// const mockBookmark: BookmarkModel = {
//   id: 1,
//   title: 'Test Bookmark',
//   url: 'https://example.com',
//   created_at: new Date('2024-09-29'),
//   updated_at: new Date('2024-09-29')
// };
//
// test('renders bookmark component with correct title and link', () => {
//   render(<Bookmark bookmark={mockBookmark} />);
//
//   // Проверка наличия заголовка
//   const titleElement = screen.getByText(/Test Bookmark/i);
//   expect(titleElement).toBeInTheDocument();
//
//   // Проверка ссылки с правильным URL и атрибутом target
//   const linkElement = screen.getByRole('link', { name: /Test Bookmark/i });
//   expect(linkElement).toHaveAttribute('href', 'https://example.com');
//   expect(linkElement).toHaveAttribute('target', '_blank');
// });
