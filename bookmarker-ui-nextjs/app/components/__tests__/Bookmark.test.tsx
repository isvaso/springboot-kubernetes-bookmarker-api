// __tests__/Bookmark.test.tsx
import React from 'react';
import '@testing-library/jest-dom';

import Bookmark from '../Bookmark';
import { Bookmark as BookmarkModel } from '../../services/models';
import expect from "expect";

const mockBookmark: BookmarkModel = {
  id: 1,
  title: 'Test Bookmark',
  url: 'https://example.com',
  created_at: new Date('2024-09-29'),
  updated_at: new Date('2024-09-29')
};


