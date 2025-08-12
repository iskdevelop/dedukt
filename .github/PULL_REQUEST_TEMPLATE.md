## Description

Brief description of the changes introduced by this PR.

## Type of Change

- [ ] Bug fix (non-breaking change which fixes an issue)
- [ ] New feature (non-breaking change which adds functionality)
- [ ] Breaking change (fix or feature that would cause existing functionality to not work as expected)
- [ ] Documentation update
- [ ] Performance improvement
- [ ] Code refactoring
- [ ] Test improvements
- [ ] Build/CI improvements

  ## Related Issues

  Fixes #(issue number)
  Closes #(issue number)
  Related to #(issue number)

## Changes Made

- [ ] Core engine modifications
- [ ] DSL changes (internal/external)
- [ ] LSP server updates
- [ ] Notebook interface changes
- [ ] Documentation updates
- [ ] Test additions/modifications
- [ ] Build system changes

### Detailed Changes

1. **Component 1**: Description of changes
2. **Component 2**: Description of changes
3. **Component 3**: Description of changes

## Testing

### How Has This Been Tested?

- [ ] Unit tests
- [ ] Integration tests
- [ ] Manual testing
- [ ] End-to-end testing

### Test Configuration

- **Platform(s)**: JVM / JavaScript / Both
- **Operating System**: Windows / macOS / Linux
- **JDK Version**:
- **Node.js Version** (if applicable):

### New Tests Added

- [ ] Unit tests for new functionality
- [ ] Integration tests for cross-component features
- [ ] Frontend tests for UI changes
- [ ] Performance tests for optimizations

## Screenshots/Demos

  <!-- If applicable, add screenshots or GIFs to help explain your changes -->

### Before
  <!-- Screenshot or description of old behavior -->

### After
  <!-- Screenshot or description of new behavior -->

## Breaking Changes

  <!-- If this is a breaking change, describe what breaks and how users should migrate -->

- [ ] This change is backwards compatible
- [ ] This change includes breaking changes

  ### Migration Guide

    <!-- If breaking changes, provide migration instructions -->

## Performance Impact

- [ ] No performance impact
- [ ] Performance improvement
- [ ] Potential performance regression (explained below)

  ### Performance Notes

    <!-- Describe any performance implications -->

## Documentation

- [ ] Documentation has been updated
- [ ] No documentation changes needed
- [ ] Documentation will be updated in a follow-up PR

### Documentation Changes

- [ ] API documentation (Dokka)
- [ ] User guide updates
- [ ] README updates
- [ ] Code examples
- [ ] Architecture documentation

## Checklist

### Code Quality

- [ ] My code follows the project's style guidelines
- [ ] I have performed a self-review of my own code
- [ ] I have commented my code, particularly in hard-to-understand areas
- [ ] My changes generate no new warnings
- [ ] I have added tests that prove my fix is effective or that my feature works

### Build and Tests

- [ ] New and existing unit tests pass locally with my changes
- [ ] `./scripts/build-all.sh` completes successfully
- [ ] `./scripts/test-all.sh` passes
- [ ] Frontend build succeeds (if applicable)
- [ ] LSP server builds and runs (if applicable)

### Dependencies

- [ ] I have checked that new dependencies are necessary
- [ ] New dependencies are properly declared in build files
- [ ] Dependency versions are compatible across modules
- [ ] No unnecessary dependencies were added

### Security

- [ ] I have reviewed my changes for security implications
- [ ] No sensitive information is exposed
- [ ] Input validation is properly implemented (if applicable)
- [ ] Authentication/authorization is maintained (if applicable)

  ## Additional Notes

    <!-- Add any additional notes for reviewers -->

## Reviewer Guidelines

### Focus Areas

Please pay special attention to:

- [ ] Algorithm correctness (for core changes)
- [ ] DSL syntax and usability (for DSL changes)
- [ ] LSP protocol compliance (for LSP changes)
- [ ] UI/UX consistency (for frontend changes)
- [ ] API design and backwards compatibility
- [ ] Error handling and edge cases
- [ ] Performance implications
- [ ] Test coverage and quality

### Testing Recommendations

Reviewers should test:

1. **Basic functionality** works as expected
2. **Edge cases** are handled properly
3. **Error conditions** are handled gracefully
4. **Performance** is acceptable
5. **Documentation** is accurate and helpful